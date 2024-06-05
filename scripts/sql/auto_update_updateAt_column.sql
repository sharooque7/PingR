CREATE  FUNCTION update_updated_at_column()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = now();
    RETURN NEW;
END;
$$ language 'plpgsql';

CREATE TRIGGER update_user_task_updated_on
    BEFORE UPDATE
    ON
        users
    FOR EACH ROW
EXECUTE PROCEDURE update_updated_on_user_task();