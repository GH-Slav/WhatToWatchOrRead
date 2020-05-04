package by.tms.whattowatchorread.ui.search

import androidx.lifecycle.ViewModel
import by.tms.whattowatchorread.entity.contentratings.ContentRatings
import by.tms.whattowatchorread.entity.details.Details
import by.tms.whattowatchorread.entity.detailsepisode.DetailsEpisode
import by.tms.whattowatchorread.entity.multisearch.MultiSearch

class SearchViewModel : ViewModel() {

    var dataModelMultiSearch: MultiSearch? = null
    var dataModelDetails: Details? = null
    var dataModelDetailsEpisode: DetailsEpisode? = null
    var dataModelContentRatings: ContentRatings? = null

}