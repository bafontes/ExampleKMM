import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Settings(

    @SerialName("listing_strategy") var listingStrategy: String? = null,
    @SerialName("has_rich_description" ) var hasRichDescription : Boolean? = null
)