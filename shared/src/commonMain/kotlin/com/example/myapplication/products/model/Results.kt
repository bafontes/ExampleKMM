import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Results(

    @SerialName("id") var id: String? = null,
    @SerialName("status") var status: String? = null,
    @SerialName("domain_id") var domainId: String? = null,
    @SerialName("settings") var settings: Settings? = Settings(),
    @SerialName("name") var name: String? = null,
    @SerialName("main_features") var mainFeatures: ArrayList<String> = arrayListOf<String>(),
    @SerialName("attributes") var attributes: ArrayList<Attributes> = arrayListOf<Attributes>(),
    @SerialName("pictures") var pictures: ArrayList<Pictures> = arrayListOf<Pictures>(),
    @SerialName("parent_id") var parentId: String? = null,
    @SerialName("children_ids") var childrenIds: ArrayList<String> = arrayListOf<String>()

)