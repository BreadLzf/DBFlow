package com.raizlabs.android.dbflow.structure;

import android.content.ContentValues;
import android.database.sqlite.SQLiteStatement;

import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.structure.container.ModelContainerAdapter;

/**
 * Description: Used for our internal Adapter classes such as generated {@link com.raizlabs.android.dbflow.structure.ModelAdapter}
 * or {@link ModelContainerAdapter}
 */
public interface InternalAdapter<TableClass extends Model, ModelClass extends Model> {

    /**
     * @return the model class this adapter corresponds to
     */
    Class<TableClass> getModelClass();

    /**
     * @return The table name of this adapter.
     */
    String getTableName();

    /**
     * Saves the specified model to the DB.
     *
     * @param model The model to save/insert/update
     */
    void save(ModelClass model);

    /**
     * Inserts the specified model into the DB.
     *
     * @param model The model to insert.
     */
    void insert(ModelClass model);

    /**
     * Updates the specified model into the DB.
     *
     * @param model The model to update.
     */
    void update(ModelClass model);

    /**
     * Deletes the model from the DB
     *
     * @param model The model to delete
     */
    void delete(ModelClass model);

    /**
     * Binds a {@link ModelClass} to the specified db statement
     *
     * @param sqLiteStatement The statement to fill
     */
    void bindToStatement(SQLiteStatement sqLiteStatement, ModelClass model);

    /**
     * Binds a {@link ModelClass} to the specified db statement
     *
     * @param contentValues The content values to fill.
     * @param model         The model values to put on the contentvalues
     */
    void bindToContentValues(ContentValues contentValues, ModelClass model);

    /**
     * Binds a {@link ModelClass} to the specified db statement, leaving out the {@link PrimaryKey#autoincrement()}
     * column.
     *
     * @param contentValues The content values to fill.
     * @param model         The model values to put on the content values.
     */
    void bindToInsertValues(ContentValues contentValues, ModelClass model);

    /**
     * If a {@link com.raizlabs.android.dbflow.structure.Model} has an autoincrementing primary key, then
     * this method will be overridden.
     *
     * @param model The model object to store the key
     * @param id    The key to store
     */
    void updateAutoIncrement(ModelClass model, long id);

    /**
     * @return The value for the {@link com.raizlabs.android.dbflow.annotation.Column#PRIMARY_KEY_AUTO_INCREMENT}
     * if it has the field. This method is overridden when its specified for the {@link ModelClass}
     */
    long getAutoIncrementingId(ModelClass model);

    /**
     * @param model The model to retrieve the caching id from.
     * @return The id that comes from the model. This is generated by subclasses of this adapter.
     */
    long getCachingId(ModelClass model);
}
