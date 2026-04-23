ALTER TABLE orders ADD COLUMN status_id INT NULL;

-- Add check constraint to ensure status_id only accepts values 0, 1, 2 or NULL
ALTER TABLE orders ADD CONSTRAINT chk_status_id_values 
CHECK (status_id IS NULL OR status_id IN (0, 1, 2));
