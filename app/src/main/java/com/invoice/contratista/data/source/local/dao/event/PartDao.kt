package com.invoice.contratista.data.source.local.dao.event

import androidx.lifecycle.LiveData
import androidx.room.*
import com.invoice.contratista.data.source.local.entity.event.PartEntity
import com.invoice.contratista.data.source.local.relations.Budget
import com.invoice.contratista.data.source.local.relations.Part
import com.invoice.contratista.ui.fragment.budget.adapter.PartItem

@Dao
interface PartDao {

    /**
     * Metodo para insertar una partida para la cotización.
     * @param partEntity Objeto partida
     *
     * @see Budget
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setPart(partEntity: PartEntity)

    /**
     * Metodo para obtener la partida de una cotización
     * @param idBudget id que hace referencia al id de la cotización
     * @return Objeto de tipo [LiveData] que contiene una lista de tipo [Part]
     */
    @Transaction
    @Query("SELECT * FROM part WHERE budget_id == :idBudget")
    fun getParts(idBudget: String): LiveData<List<Part>>

    /**
     * Metodo para obtener una partida con su propio id.
     * @param idPart id de la partida que retorna.
     * @return Objeto de tipo [LiveData] que contiene un objeto de tipo [Part]
     */
    @Transaction
    @Query("SELECT * FROM part WHERE id == :idPart LIMIT 1")
    fun getPart(idPart: String): LiveData<Part>

    @Query("SELECT number FROM part WHERE budget_id == :idBudget ORDER BY number DESC LIMIT 1")
    fun getNumberOfPart(idBudget: String): Int

    @Query(
        "INSERT INTO part (id, discount, number, quantity, budget_id, reserved_id) " +
                "VALUES ( :idPart " +
                "       , 0.0 " +
                "       , IFNULL((SELECT number FROM part WHERE budget_id == :idBudget ORDER BY number DESC LIMIT 1) + 1, 1) " +
                "       , 1 " +
                "       , :idBudget " +
                "       , :idReserved)"
    )
    fun createPart(idPart: String, idBudget: String, idReserved: String)

    @Query("UPDATE part SET quantity = :quantity WHERE id == :idPart")
    fun updateQuantity(quantity: Int, idPart: String)

    @Query("UPDATE part SET discount = :discount WHERE id == :idPart")
    fun updateDiscount(discount: Int, idPart: String)

    @Query("UPDATE reserved SET product_id = :idProduct WHERE id = :idReserved")
    fun updateProduct(idProduct: String, idReserved: String)

    @Query(
        "SELECT pa.id                                                    AS id_part " +
                "     , IFNULL(pb.description, 'NOT')                            AS product_name " +
                "     , pa.quantity " +
                "     , pa.number                                                AS part_number " +
                "     , IFNULL(pb.unit_name, '')                                 AS unit_name" +
                "     , IFNULL(pr.id, 'NOT')                                     AS product_id " +
                "     , IFNULL(((pr.unit_price * pa.quantity) - pa.discount), 0) AS amount " +
                "FROM part pa " +
                "         LEFT JOIN reserved r on pa.reserved_id = r.id " +
                "         LEFT JOIN price pr on pr.id = r.price_id " +
                "         LEFT JOIN product_inventory pi on pr.product_id = pi.product_id " +
                "         LEFT JOIN product p on pi.product_id = p.id " +
                "         LEFT JOIN product_base pb on p.product_base_id = pb.id " +
                "WHERE pa.budget_id = :idBudget"
    )
    fun getPartsForRecycler(idBudget: String): LiveData<List<PartItem>>

}