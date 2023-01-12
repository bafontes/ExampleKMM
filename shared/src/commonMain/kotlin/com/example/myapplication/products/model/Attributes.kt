import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Attributes(

    @SerialName("id") var id: String? = null,
    @SerialName("name") var name: String? = null,
    @SerialName("value_id") var valueId: String? = null,
    @SerialName("value_name") var valueName: String? = null,
    @SerialName("values") var values    : ArrayList<Values> = arrayListOf<Values>()
)