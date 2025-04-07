Step 1: Spring Boot API (MainApplication.java)
A simple Spring Boot REST API that serves data:

The Principal principal object will hold the authenticated user after successful authentication.

Step 2: OAuth2 Proxy Sidecar
Instead of adding authentication logic inside the Spring Boot app, we use OAuth2 Proxy as a sidecar. It will:
Authenticate users via Google, GitHub, or Keycloak.
Forward only authenticated requests to the Spring Boot app.
OAuth2 Proxy Configuration (oauth2-proxy.cfg)

provider = "google"
email_domains = [ "*" ]
upstream = "http://spring-boot-app:8080/"
http_address = "0.0.0.0:4180"
cookie_secret = "random_secret_key"
This restricts access to authenticated users only.

upstream is our Spring Boot service.

The proxy listens on port 4180.

Step 3: Docker Compose for Sidecar Pattern
A Docker Compose file to run both containers:

yaml
Copy
Edit
version: '3.8'
services:
  spring-boot-app:
    image: my-spring-app:latest
    ports:
      - "8080:8080"

  oauth2-proxy:
    image: quay.io/oauth2-proxy/oauth2-proxy:latest
    ports:
      - "4180:4180"
    depends_on:
      - spring-boot-app
    environment:
      OAUTH2_PROXY_PROVIDER: "google"
      OAUTH2_PROXY_CLIENT_ID: "your-client-id"
      OAUTH2_PROXY_CLIENT_SECRET: "your-client-secret"
      OAUTH2_PROXY_EMAIL_DOMAINS: "*"
      OAUTH2_PROXY_UPSTREAMS: "http://spring-boot-app:8080"

Step 4: Testing the Security Sidecar
Start Services

docker-compose up -d
Access the API via OAuth2 Proxy
Open in browser:

Edit
http://localhost:4180/api/data
OAuth2 Proxy will Redirect for Authentication

If logged in, the request passes to Spring Boot.

If unauthenticated, the request is blocked.

