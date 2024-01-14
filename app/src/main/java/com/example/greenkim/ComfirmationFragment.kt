package com.example.greenkim

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.greenkim.databinding.FragmentComfirmationBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ComfirmationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ComfirmationFragment : Fragment() {
    // TODO: Rename and change types of parameters

    val binding by lazy { FragmentComfirmationBinding.inflate(layoutInflater) }
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val postList = getPosts()
        val adapter = PostsAdapter()
        adapter.listData = postList
        binding.recyclerview.adapter =adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(context)

        return binding.root
    }

    fun getPosts(): MutableList<posts> {

        var postList = mutableListOf<posts>()
        for (i in 1..10) {
            val title = "샘플: ${i} "
            val day = "202"
            val postdata = posts(
                i,
                date = day,
                title = title,
                profile_pic = R.drawable.plastic_free,
                nickname = "엉금",
                contents = "ex",
                chatCounts = "1",
                likeCounts = "2"
            )

            postList.add(postdata)

        }
        return postList
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ComfirmationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ComfirmationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}