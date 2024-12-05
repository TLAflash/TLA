package it.dogior.hadEnough

import com.lagradost.cloudstream3.HomePageResponse
import com.lagradost.cloudstream3.LoadResponse
import com.lagradost.cloudstream3.TvType
import com.lagradost.cloudstream3.MainAPI
import com.lagradost.cloudstream3.MainPageRequest
import com.lagradost.cloudstream3.SearchResponse
import com.lagradost.cloudstream3.SubtitleFile
import com.lagradost.cloudstream3.newHomePageResponse
import com.lagradost.cloudstream3.utils.ExtractorLink

class YouTubePlaylistsProvider : MainAPI() {
    override var mainUrl = MAIN_URL
    override var name = "YouTube Playlists"
    override val supportedTypes = setOf(TvType.Others)
    override val hasMainPage = true
    override var lang = "un"

    private val ytParser = YouTubeParser(this.name)

    companion object{
        const val MAIN_URL = "https://www.youtube.com"
    }

    override suspend fun getMainPage(page: Int, request: MainPageRequest): HomePageResponse? {
        val videoUrls = emptyList<SearchResponse>()
//        val videoUrls = ytParser.search("Hermitcraft")
        return newHomePageResponse("Banana", videoUrls, false)
    }

    override suspend fun search(query: String): List<SearchResponse> {
        val videoUrls = ytParser.search(query)
        return videoUrls
    }

    override suspend fun load(url: String): LoadResponse {
        val video = ytParser.videoToLoadResponse(url)
        return video
    }

    override suspend fun loadLinks(
        data: String,
        isCasting: Boolean,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit,
    ): Boolean {

        YouTubeExtractor().getUrl(data, "", subtitleCallback, callback)
        return true
    }
}