package com.newsapp.withmvvm.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.newsapp.withmvvm.databinding.FragmentArticleBinding
import com.newsapp.withmvvm.ui.NewsActivity
import com.newsapp.withmvvm.ui.NewsViewModel

class ArticleFragment : Fragment() {

    private lateinit var viewModel: NewsViewModel
    private val args: ArticleFragmentArgs by navArgs()

    private var _binding: FragmentArticleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentArticleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as NewsActivity).newsViewModel

        val article = args.article

        if (viewModel.checkArticleExist(article.url!!)) {
            binding.fab.visibility = View.GONE
        } else {
            binding.fab.visibility = View.VISIBLE
        }

        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }

        binding.fab.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(
                /**
                 * This line ensures we aren't overlapping fab or bottom nav view
                 * And it pushes the fab up as the SnackBar appears and pushes down when SnackBar hides
                 */
                binding.snackRoot,
                "Article Saved Successfully",
                Snackbar.LENGTH_SHORT
            ).show()

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}