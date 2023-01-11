import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Values(

    @SerialName("id") var id: String? = null,
    @SerialName("name") var name: String? = null

)