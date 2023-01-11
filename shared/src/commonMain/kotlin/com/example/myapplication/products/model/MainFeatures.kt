import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MainFeatures(

    @SerialName("text") var text: String? = null,
    @SerialName("type") var type: String? = null,
    @SerialName("metadata") var metadata: Metadata? = Metadata()

)