import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse(

    @SerialName("keywords") var keywords: String? = null,
    @SerialName("paging") var paging: Paging? = Paging(),
    @SerialName("results") var results: ArrayList<Results> = arrayListOf()
)