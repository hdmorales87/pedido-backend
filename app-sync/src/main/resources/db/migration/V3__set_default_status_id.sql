ALTER TABLE orders ALTER COLUMN status_id SET DEFAULT 0;

-- Update existing NULL records to have default value 0
UPDATE orders SET status_id = 0 WHERE status_id IS NULL;
