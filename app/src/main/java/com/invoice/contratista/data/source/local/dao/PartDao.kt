package com.invoice.contratista.data.source.local.dao

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
    @Query("SELECT * FROM part WHERE idBudget == :idBudget")
    fun getParts(idBudget: String): LiveData<List<Part>>

    /**
     * Metodo para obtener una partida con su propio id.
     * @param idPart id de la partida que retorna.
     * @return Objeto de tipo [LiveData] que contiene un objeto de tipo [Part]
     */
    @Transaction
    @Query("SELECT * FROM part WHERE id == :idPart LIMIT 1")
    fun getPart(idPart: String): LiveData<Part>

    @Query("SELECT number FROM part WHERE idBudget == :idBudget ORDER BY number DESC LIMIT 1")
    fun getNumberOfPart(idBudget: String): Int

    @Query(
        "INSERT INTO part " +
                "SELECT  " +
                "   :idPart AS id," +
                "   IFNULL((SELECT number FROM part WHERE idBudget == :idBudget ORDER BY number DESC LIMIT 1) + 1, 1) AS number," +
                "   :idBudget AS idBudget," +
                "   (SELECT id FROM product LIMIT 1) as idProduct," +
                "   1 AS quantity," +
                "   0.0 AS discount"
    )
    fun createPart(idPart: String, idBudget: String)

    @Query("UPDATE part SET quantity = :quantity WHERE id == :idPart")
    fun updateQuantity(quantity: Int, idPart: String)

    @Query("UPDATE part SET discount = :discount WHERE id == :idPart")
    fun updateDiscount(discount: Int, idPart: String)

    @Query("UPDATE part SET idProduct = :idProduct WHERE id == :idPart")
    fun updateProduct(idProduct: String, idPart: String)

    @Query(
        "SELECT " +
                "    p.id AS id_part, " +
                "    pr.description AS product_name, " +
                "    p.quantity, " +
                "    p.number AS part_number, " +
                "    pr.unit_name, " +
                "    pr.id as id_product," +
                "    ((pr.price * p.quantity)-p.discount) as amount " +
                "FROM product AS pr, part AS p " +
                "WHERE p.idBudget == :idBudget AND pr.id == p.idProduct"
    )
    fun getPartsForRecycler(idBudget: String): LiveData<List<PartItem>>

}