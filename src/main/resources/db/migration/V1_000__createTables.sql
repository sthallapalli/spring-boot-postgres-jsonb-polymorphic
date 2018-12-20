CREATE SCHEMA IF NOT EXISTS document;

CREATE TABLE IF NOT EXISTS document.document (
  id  bigserial PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  type VARCHAR(100) NOT NULL,
  page_count INT NOT NULL,
  data JSONB,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL
);