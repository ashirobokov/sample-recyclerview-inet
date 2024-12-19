package ru.application.recyclerview.topic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.application.recyclerview.R
import ru.application.recyclerview.databinding.FragmentTopicBinding
import ru.application.recyclerview.model.topics

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class TopicFragment : Fragment() {

    private var _binding: FragmentTopicBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTopicBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.topicRecycler.adapter = TopicItemAdapter(requireContext()).apply {
            submitList(topics)
        }

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(TopicFragmentDirections.actionTopicFragmentToCourseFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}