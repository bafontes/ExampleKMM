import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductDetailResponse(

    @SerialName("id") var id: String? = null,
    @SerialName("status") var status: String? = null,
    @SerialName("sold_quantity") var soldQuantity: Int? = null,
    @SerialName("domain_id") var domainId: String? = null,
    @SerialName("permalink") var permalink: String? = null,
    @SerialName("name") var name: String? = null,
    @SerialName("family_name") var familyName: String? = null,
    @SerialName("buy_box_winner") var buyBoxWinner: String? = null,
    @SerialName("buy_box_winner_price_range") var buyBoxWinnerPriceRange: String? = null,
    @SerialName("pickers") var pickers: ArrayList<Pickers> = arrayListOf(),
    @SerialName("pictures") var pictures: ArrayList<Pictures> = arrayListOf(),
    @SerialName("main_features") var mainFeatures: ArrayList<MainFeatures> = arrayListOf(),
    @SerialName("attributes") var attributes: ArrayList<Attributes> = arrayListOf(),
    @SerialName("short_description") var shortDescription: ShortDescription? = ShortDescription(),
    @SerialName("parent_id") var parentId: String? = null,
    @SerialName("children_ids") var childrenIds: ArrayList<String> = arrayListOf(),
    @SerialName("settings") var settings: Settings? = Settings(),
    @SerialName("authority_types") var authorityTypes: ArrayList<String> = arrayListOf(),
    @SerialName("date_created") var dateCreated: String? = null

)