CREATE TABLE IF NOT EXISTS grablist_roles(
   id SERIAL PRIMARY KEY,
   name VARCHAR(50) UNIQUE NOT NULL,
   description VARCHAR(100),
   created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE INDEX idx_grablist_roles_id ON grablist_roles(id);