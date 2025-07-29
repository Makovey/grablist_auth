CREATE TABLE IF NOT EXISTS grablist_users(
    id SERIAL PRIMARY KEY,
    email VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    phone VARCHAR(30) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    role_id INTEGER REFERENCES grablist_roles(id) NOT NULL,
    is_active BOOLEAN DEFAULT TRUE NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
    last_login_at TIMESTAMP WITH TIME ZONE,
    deleted_at TIMESTAMP WITH TIME ZONE,
    UNIQUE(email),
    UNIQUE(phone)
);

CREATE INDEX idx_grablist_users_email ON grablist_users(email);
CREATE INDEX idx_grablist_users_phone ON grablist_users(phone);