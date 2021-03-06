package br.com.nerdrapido.themoviedbapp.ui.moviedetail.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.nerdrapido.themoviedbapp.R
import br.com.nerdrapido.themoviedbapp.data.model.movie.MovieResponse
import br.com.nerdrapido.themoviedbapp.ui.components.infoitem.ItemInfoViewMultiline
import br.com.nerdrapido.themoviedbapp.ui.components.infoitem.ItemInfoViewSingleLine
import kotlinx.android.synthetic.main.fragment_movie_detail.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.Calendar.YEAR

/**
 * Created By FELIPE GUSBERTI @ 13/03/2020
 */
class InfoMovieDetailFragment : MovieDetailFragment() {

    override var title = ""

    var movieResponse: MovieResponse? = null
        set(value) {
            setInfo(value)
            field = value
        }

    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_detail, null)
    }

    override fun onResume() {
        super.onResume()
        setInfo(movieResponse)
    }
    private fun setInfo(movieResponse: MovieResponse?) {

        detailInfoContainer?.removeAllViews()
        addInfoView(
            context?.getString(R.string.detail_info_fragment_original_title),
            movieResponse?.originalTitle
        )

        val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val calendar = Calendar.getInstance()
        movieResponse?.releaseDate?.let {
            calendar.time = format.parse(it)
        }
        addInfoView(context?.getString(R.string.detail_info_fragment_year), calendar.get(YEAR).toString())
        addInfoView(
            context?.getString(R.string.detail_info_fragment_overview),
            movieResponse?.overview,
            true
        )
    }

    private fun addInfoView(title: String?, info: String?, multiline: Boolean = false) {
        context?.let {
            val infoView = if (multiline) ItemInfoViewMultiline(it) else ItemInfoViewSingleLine(it)
            infoView.title = title
            infoView.info = info
            detailInfoContainer.addView(infoView)
        }
    }
}