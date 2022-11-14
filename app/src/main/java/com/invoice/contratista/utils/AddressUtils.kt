package com.invoice.contratista.utils

import android.content.res.Resources
import com.invoice.contratista.R
import com.invoice.contratista.data.local.entity.AddressEntity
import com.invoice.contratista.databinding.LayoutAddressBinding
import com.invoice.contratista.utils.InputUtils.getTextWithValidation
import java.util.*

object AddressUtils {
    fun LayoutAddressBinding.getAddressObject() = AddressEntity(
        id = UUID.randomUUID().toString(),
        street = layoutStreet.getTextWithValidation(),
        exterior = layoutExterior.getTextWithValidation(),
        interior = layoutInterior.getTextWithValidation(),
        neighborhood = layoutNeighborhood.getTextWithValidation(),
        city = layoutCity.getTextWithValidation(),
        municipality = layoutMunicipality.getTextWithValidation(),
        zip = layoutZip.getTextWithValidation(),
        state = layoutState.getTextWithValidation(),
        country = layoutCountry.getTextWithValidation(),
        idCustomer = "",
    )

    fun AddressEntity.isNotEmpty() =
        street.isNotEmpty()
                && exterior.isNotEmpty()
                && neighborhood.isNotEmpty()
                && city.isNotEmpty()
                && municipality.isNotEmpty()
                && zip.isNotEmpty()
                && state.isNotEmpty()

    fun AddressEntity.getAddress(resources: Resources) = "$street, " +
            "${
                if (interior.isEmpty())
                    "${resources.getString(R.string.exterior)} $exterior"
                else "${resources.getString(R.string.interior)} $interior, " +
                        "${resources.getString(R.string.exterior)} $exterior"
            }, " +
            "$zip, $neighborhood, " +
            "$city, ${municipality}, " +
            "$state, $country"
}