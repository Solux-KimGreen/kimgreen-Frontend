package com.example.greenkim

import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.greenkim.R
import com.example.greenkim.databinding.RecyclerviewItemBinding
import com.example.greenkim.posts

class PostsAdapter(private val context: Context) : RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {

    var listData = mutableListOf<posts>()
    var onPostItemClickListener: OnPostItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = RecyclerviewItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = listData[position]
        holder.setPost(post)
    }

    // 추가된 부분: PostsAdapter 클래스에 updateLikeImage 함수를 추가
    fun updateLikeImage(liked: Boolean) {
        val position = findPostPosition()
        if (position != RecyclerView.NO_POSITION) {
            val clickedPost = listData[position]
            clickedPost.liked = liked
            notifyItemChanged(position)
        }
    }

    private fun findPostPosition(): Int {
        // 이 부분은 해당 post의 position을 찾아주는 로직을 추가해야 합니다.
        // 예를 들어, post의 ID나 다른 고유한 값으로 position을 찾을 수 있습니다.
        // 임시로 첫 번째 post의 position을 반환하도록 설정하였습니다.
        return if (listData.isNotEmpty()) 0 else RecyclerView.NO_POSITION
    }

    inner class PostViewHolder(private val binding: RecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        // 변경된 부분: setPost 함수 대신 init 블록에 직접 내용을 추가
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val clickedPost = listData[position]
                    onPostItemClickListener?.onPostItemClick(clickedPost)
                }
            }

            // contents 부분을 클릭할 때 DetailPostActivity로 전환
            binding.contents.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val clickedPost = listData[position]

                    // 여기에 DetailPostActivity를 시작하는 코드 추가
                    val intent = Intent(itemView.context, DetailPostActivity::class.java)
                    intent.putExtra("postId", clickedPost.no) // postId를 DetailPostActivity로 전달 (예시로 id를 전달하도록 설정)
                    itemView.context.startActivity(intent)
                }
            }
        }

        fun setPost(post: posts) {
            binding.nickName.text = "아기자기"
            binding.chatCounts.text = "${post.no}"
            binding.likeCounts.text = "${post.likeCounts}"

            // 초기 좋아요 이미지 설정
            updateLikeImage(post.liked)

            // 좋아요 버튼 클릭 이벤트 처리
            binding.Like.setOnClickListener {
                // 좋아요 상태 변경
                post.liked = !post.liked
                // 좋아요 애니메이션 추가
                animateLike(post.liked)
                // 좋아요 상태에 따라 이미지 변경
                updateLikeImage(post.liked)
                // 좋아요 상태에 따라 likeCounts 변경
                if (post.liked) {
                    // 좋아요가 선택된 경우
                    post.likeCounts++
                } else {
                    // 좋아요가 해제된 경우에만 좋아요 수 감소
                    post.likeCounts--
                }
                // likeCounts 갱신
                binding.likeCounts.text = "${post.likeCounts}"
            }

            binding.overflowButton.setOnClickListener {
                showReportReasonDialog(context)
            }

        }
        private fun updateLikeImage(liked: Boolean) {
            // 좋아요 상태에 따라 이미지 변경
            if (liked) {
                // 선택된 경우
                binding.Like.setImageResource(R.drawable.baseline_favorite_24)
                // 선택된 경우의 색상 설정
            } else {
                // 선택되지 않은 경우
                binding.Like.setImageResource(R.drawable.baseline_favorite_border_24)
                // 원래의 색상 설정
            }
        }

        private fun animateLike(liked: Boolean) {
            // 좋아요 애니메이션 추가
            val animator = if (liked) {
                ObjectAnimator.ofFloat(binding.Like, "scaleX", 1f, 1.2f, 1f)
            } else {
                ObjectAnimator.ofFloat(binding.Like, "scaleX", 1f, 0.8f, 1f)
            }

            animator.duration = 300
            animator.interpolator = AccelerateInterpolator()
            animator.start()
        }

    }

    interface OnPostItemClickListener {
        fun onPostItemClick(post: posts)
    }

    private fun showReportReasonDialog(context: Context) {
        val reasons = arrayOf("거짓 정보", "상업 광고", "폭력성/음란성", "기타")
        val builder = AlertDialog.Builder(context)
            .setTitle("신고 사유 선택")
            .setItems(reasons) { dialog, which ->
                val selectedReason = reasons[which]
                dialog.dismiss()
            }

        builder.show()
    }

}