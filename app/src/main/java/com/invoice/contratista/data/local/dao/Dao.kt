package com.invoice.contratista.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Transaction
import com.invoice.contratista.data.local.entity.AddressEntity
import com.invoice.contratista.data.local.entity.CustomerEntity
import com.invoice.contratista.data.local.entity.DateEntity
import com.invoice.contratista.data.local.entity.EventEntity
import com.invoice.contratista.data.local.entity.event.BudgetEntity
import com.invoice.contratista.data.local.entity.event.NoteEntity
import com.invoice.contratista.data.local.entity.event.PartEntity
import com.invoice.contratista.data.local.entity.event.ScheduleEntity
import com.invoice.contratista.data.local.entity.product.LocalTaxEntity
import com.invoice.contratista.data.local.entity.product.ProductEntity
import com.invoice.contratista.data.local.entity.product.TaxEntity
import com.invoice.contratista.data.local.relations.*
import com.invoice.contratista.ui.fragment.part.ProductsItem

@Dao
interface Dao {

    // region Budget
    /**
     * Metodo para insertar una cotización.
     * @param budgetEntity Objeto cotización
     */
    @Insert(onConflict = REPLACE)
    fun setBudget(budgetEntity: BudgetEntity)

    /**
     * Metodo para obtener el objeto budget completo
     * @param id Identificador de la cotizacion al que pertenece el seguimiento de la cotización.
     * @return Objeto de tipo [LiveData] que contiene un objeto de tipo [Budget]
     */
    @Transaction
    @Query("SELECT * FROM budget WHERE id == :id LIMIT 1")
    fun getBudget(id: String): LiveData<Budget>

    /**
     * Metodo para obtener todas las cotizaciones completas
     * @return Lista de objetos de tipo [Budget]
     */
    @Transaction
    @Query("SELECT * FROM budget")
    fun getBudgets(): LiveData<List<Budget>>

    @Query("SELECT number FROM budget ORDER BY number DESC LIMIT 1")
    fun getNumberBudget(): Int

    // endregion

    // region Part
    /**
     * Metodo para insertar una partida para la cotización.
     * @param partEntity Objeto partida
     *
     * @see Budget
     */
    @Insert(onConflict = REPLACE)
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

    // endregion

    // region Address
    /**
     * Metodo para insertar una dirección.
     * @param addressEntity Objeto dirección
     */
    @Insert(onConflict = REPLACE)
    fun setAddress(addressEntity: AddressEntity)

    // endregion

    // region Customer
    /**
     * Metodo para insertar un objeto que contiene la información del cliente.
     * @param customerEntity Objeto de tipo [CustomerEntity]
     * @see CustomerEntity
     */
    @Insert(onConflict = REPLACE)
    fun setCustomer(customerEntity: CustomerEntity)

    /**
     * Metodo para obtener a todos los clientes
     * @return Objeto de tipo [LiveData] que, a su vez, contiene uno de tipo [CustomerEntity].
     */
    @Query("SELECT * FROM customer")
    fun getCustomers(): LiveData<List<CustomerEntity>>

    /**
     * Metodo para obtener a un cliente en especifico.
     * @param idCustomer id del cliente
     * @return Retorna un objeto de tipo [LiveData] que, a su vez, contiene uno de tipo [Customer]
     * que contiene todos los objetos relacionados al **Cliente**.
     */
    @Transaction
    @Query("SELECT * FROM customer WHERE id == :idCustomer LIMIT 1")
    fun getCustomer(idCustomer: String): LiveData<Customer>

    /**
     * Metodo para obtener a un cliente en especifico.
     * @param idCustomer id del cliente
     * @return Retorna un objeto de tipo [LiveData] que, a su vez, contiene uno de tipo [CustomerEntity]
     * que contiene todos los objetos relacionados al **Cliente**.
     */
    @Transaction
    @Query("SELECT * FROM customer WHERE id == :idCustomer LIMIT 1")
    fun getCustomerEntity(idCustomer: String): LiveData<CustomerEntity>

    // endregion

    // region Product
    /**
     * Metodo para insertar un producto.
     * @param productEntity Objeto de tipo [ProductEntity]
     */
    @Insert(onConflict = REPLACE)
    fun setProduct(productEntity: ProductEntity)

    /**
     * Metodo para obtener todos los productos.
     * @return Objeto de tipo [LiveData] que contiene una lista de objetos de tipo [ProductEntity]
     */
    @Query("SELECT * FROM product")
    fun getProducts(): LiveData<List<ProductEntity>>

    /**
     * Metodo para obtener un producto por su id
     * @return Objeto de tipo [LiveData] que contiene un objeto de tipo [Product] que lleva todos
     * los obetos relacionados a un **Producto**.
     */
    @Transaction
    @Query("SELECT * FROM product WHERE id == :idProduct LIMIT 1")
    fun getProduct(idProduct: String): LiveData<Product>

    // region Insert Taxes
    /**
     * Metodo para insertar un impuetso local a un Producto.
     * @param localTaxEntity Objeto del impuesto local
     *
     * @see Product.localTaxes
     * @see LocalTaxEntity
     */
    @Insert(onConflict = REPLACE)
    fun setLocalTax(localTaxEntity: LocalTaxEntity)

    /**
     * Metodo para insertar un impuesto normal.
     * @param taxEntity Objeto de tipo [TaxEntity]
     * @see Product.taxes
     * @see TaxEntity
     */
    @Insert(onConflict = REPLACE)
    fun setTax(taxEntity: TaxEntity)

    // endregion

    // endregion

    // region Event
    /**
     * Metodo para insertar un evento
     * @param event Objeto de tipo [EventEntity]
     */
    @Insert(onConflict = REPLACE)
    fun setEvent(event: EventEntity)

    /**
     * Metodo para obtener todos los eventos activos
     * @return Lista de objetos de tipo [EventEntity]
     */
    @Query("SELECT * FROM event WHERE state != 'Realizado'")
    fun getEvents(): LiveData<List<EventEntity>>

    @Transaction
    @Query("SELECT * FROM event WHERE id == :idEvent")
    fun getEvent(idEvent: String): LiveData<Event>

    @Query("UPDATE event SET note = :note WHERE id == :idEvent")
    fun updateNoteEvent(idEvent: String, note: String)

    // endregion

    /**
     * Metodo para obtener las fechas del historial de un evento
     * @return Lista de objetos de tipo [DateEntity]
     */
    @Query("SELECT * FROM date WHERE idReference == :idEvent")
    fun getDates(idEvent: String): LiveData<List<DateEntity>>

    /**
     * Metodo para insertar una fecha
     */
    @Insert(onConflict = REPLACE)
    fun setDate(dateEntity: DateEntity)

    @Insert(onConflict = REPLACE)
    fun createNote(noteEntity: NoteEntity)

    @Query("UPDATE note SET note = :note WHERE id == :idNote")
    fun updateNote(idNote: String, note: String)

    @Query("SELECT * FROM note WHERE id_event == :idEvent")
    fun getNotes(idEvent: String): LiveData<List<NoteEntity>>

    @Query("SELECT note FROM note WHERE id == :idNote")
    fun getNote(idNote: String): LiveData<String>

    @Query("SELECT DISTINCT * FROM schedule WHERE id_event == :idEvent ORDER BY date")
    fun getSchedules(idEvent: String): LiveData<List<ScheduleEntity>>

    @Query("SELECT DISTINCT * FROM schedule ORDER BY date")
    fun getSchedules(): LiveData<List<ScheduleEntity>>

    @Query(
        "INSERT INTO schedule " +
                "VALUES(:idSchedule, :idEvent, :date, :state, :note, :idAddress, " +
                "(SELECT legal_name " +
                "FROM customer " +
                "WHERE id == :idCustomer LIMIT 1))"
    )
    fun createSchedule(
        idSchedule: String,
        idEvent: String,
        date: String,
        state: String,
        note: String,
        idAddress: String,
        idCustomer: String
    )

    @Query("UPDATE schedule SET date =:date, note = :note WHERE id == :idSchedule")
    fun updateSchedule(date: String, note: String, idSchedule: String)

    @Query(
        "UPDATE address " +
                "SET street = :street," +
                "exterior = :exterior," +
                "interior = :interior," +
                "neighborhood = :neighborhood," +
                "city = :city," +
                "municipality = :municipality," +
                "zip = :zip," +
                "state = :state " +
                "WHERE idCustomer == :idSchedule"
    )
    fun updateAddress(
        street: String,
        exterior: String,
        interior: String,
        neighborhood: String,
        city: String,
        municipality: String,
        zip: String,
        state: String,
        idSchedule: String
    )

    @Query("SELECT * FROM schedule WHERE id == :idSchedule")
    fun getSchedule(idSchedule: String): LiveData<ScheduleEntity>

    @Query("SELECT * FROM address WHERE idCustomer == :idSchedule")
    fun getAddressOfSchedule(idSchedule: String): LiveData<AddressEntity>

    @Query("UPDATE schedule SET state = 'Atendido' WHERE id == :idSchedule")
    fun updateStateSchedule(idSchedule: String)

    @Query("SELECT * FROM budget WHERE id_event == :idEvent ORDER BY number ASC")
    fun getBudgetsEntity(idEvent: String): LiveData<List<BudgetEntity>>

    @Query("SELECT id, description FROM product ORDER BY description ASC")
    fun getProductsForSelector(): LiveData<List<ProductsItem>>

    @Query("SELECT number FROM part WHERE idBudget == :idBudget ORDER BY number DESC LIMIT 1")
    fun getNumberOfPart(idBudget: String): Int
}