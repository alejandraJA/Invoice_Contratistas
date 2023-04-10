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
        "INSERT INTO part " +
                "SELECT  " +
                "   :idPart AS id," +
                "   IFNULL((SELECT number FROM part WHERE budget_id == :idBudget ORDER BY number DESC LIMIT 1) + 1, 1) AS number," +
                "   :idBudget AS idBudget," +
                "   (SELECT id FROM product LIMIT 1) as idProduct," +
                "   1 AS quantity," +
                "   0.0 AS discount," +
                "   ''"
    )
    fun createPart(idPart: String, idBudget: String)

    @Query("UPDATE part SET quantity = :quantity WHERE id == :idPart")
    fun updateQuantity(quantity: Int, idPart: String)

    @Query("UPDATE part SET discount = :discount WHERE id == :idPart")
    fun updateDiscount(discount: Int, idPart: String)

    @Query("UPDATE part SET product_id = :idProduct WHERE id == :idPart")
    fun updateProduct(idProduct: String, idPart: String)

    @Query(
        "SELECT pa.id                                         AS id_part\n" +
                "     , pb.description                                AS product_name\n" +
                "     , pa.quantity\n" +
                "     , pa.number                                     AS part_number\n" +
                "     , pb.unit_name\n" +
                "     , pr.id                                         AS product_id\n" +
                "     , ((pr.unit_price * pa.quantity) - pa.discount) AS amount\n" +
                "FROM part pa\n" +
                "         LEFT JOIN reserved r on pa.reserved_id = r.id\n" +
                "         LEFT JOIN price pr on pr.id = r.price_id\n" +
                "         LEFT JOIN product_inventory pi on pr.product_id = pi.product_id\n" +
                "         LEFT JOIN product p on pi.product_id = p.id\n" +
                "         LEFT JOIN product_base pb on p.product_base_id = pb.id\n" +
                "WHERE pa.budget_id = :idBudget"
    )
    fun getPartsForRecycler(idBudget: String): LiveData<List<PartItem>>

}