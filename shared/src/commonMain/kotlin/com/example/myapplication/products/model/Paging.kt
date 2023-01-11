import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Paging(

    @SerialName("total") var total: Int? = null,
    @SerialName("limit") var limit: Int? = null,
    @SerialName("offset") var offset: Int? = null

)