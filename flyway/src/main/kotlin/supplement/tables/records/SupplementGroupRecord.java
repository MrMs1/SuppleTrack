/*
 * This file is generated by jOOQ.
 */
package supplement.tables.records;


import java.time.LocalDateTime;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;

import supplement.tables.SupplementGroup;


/**
 * サプリメントグループテーブル
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SupplementGroupRecord extends UpdatableRecordImpl<SupplementGroupRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.supplement_group.name</code>. サプリメントグループ名
     */
    public SupplementGroupRecord setName(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.supplement_group.name</code>. サプリメントグループ名
     */
    public String getName() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.supplement_group.created_at</code>.
     */
    public SupplementGroupRecord setCreatedAt(LocalDateTime value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.supplement_group.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(1);
    }

    /**
     * Setter for <code>public.supplement_group.updated_at</code>.
     */
    public SupplementGroupRecord setUpdatedAt(LocalDateTime value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.supplement_group.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SupplementGroupRecord
     */
    public SupplementGroupRecord() {
        super(SupplementGroup.SUPPLEMENT_GROUP);
    }

    /**
     * Create a detached, initialised SupplementGroupRecord
     */
    public SupplementGroupRecord(String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(SupplementGroup.SUPPLEMENT_GROUP);

        setName(name);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised SupplementGroupRecord
     */
    public SupplementGroupRecord(supplement.tables.pojos.SupplementGroup value) {
        super(SupplementGroup.SUPPLEMENT_GROUP);

        if (value != null) {
            setName(value.getName());
            setCreatedAt(value.getCreatedAt());
            setUpdatedAt(value.getUpdatedAt());
            resetChangedOnNotNull();
        }
    }
}
