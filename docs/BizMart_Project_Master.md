# BizMart - Project Master Tracker

## Project Information

### Project Name

BizMart - Business Valuation & Acquisition Marketplace

### Project Type

Startup MVP

### Goal

A platform where business owners can list companies for acquisition or investment, and buyers/investors can discover and connect with them.

### MVP Scope

* Authentication & Authorization
* Seller Profile
* Company Management
* Financial Information
* Business Valuation
* Business Listing
* Buyer Profile
* Interest Management
* Basic Matching Engine
* Admin Dashboard

---

# Technology Stack

## Backend

* Java 21
* Spring Boot
* Spring Security
* JWT
* Spring Data JPA
* Hibernate
* MySQL
* Maven

## Frontend

* React
* Bootstrap 5
* Axios

## Tools

* STS
* MySQL Workbench
* Postman
* VS Code

---

# Architecture Decisions

## Decision 001

Use JWT Authentication instead of Session Authentication.

Reason:
Industry standard and React-friendly.

Status:
Approved

---

## Decision 002

Use React Frontend and Spring Boot REST APIs.

Reason:
Portfolio and industry relevance.

Status:
Approved

---

# Database Tables

## Planned

* users
* roles
* companies
* company_financials
* valuations
* listings
* buyer_profiles
* interests

---

# Milestone Tracking

## Milestone 0 - Project Setup

Status:
COMPLETED

Tasks:

- [x] Create Spring Boot Project
- [x] Configure MySQL
- [x] Verify Application Startup
- [x] Create Base Package Structure

Notes:

None

---

## Milestone 1 - Authentication

Status:
COMPLETED

Tasks:
* [x] Create Package Structure
* [x] User Entity
* [x] Role Enum
* [x] User Repository
* [x] Registration DTO
* [x] AuthService
* [x] AuthController
* [x] Registration API
* [x] Password Encryption (BCrypt)
* [x] Login API
* [x] Global Exception Handler
* [x] JWT Generation
* [x] JWT Extraction
* [x] JWT Validation
* [x] Spring Security Configuration
* [x] Role-based JWT

---

## Milestone 2 - Company Management Module

Status:
COMPLETED

Tasks:

* [x] Company Entity
* [x] Company Repository
* [x] Company DTO
* [x] Company Service
* [x] Company Controller
* [x] Create Company API
* [x] Get Company API
* [x] Get All Companies API
* [x] Update Company API
* [x] Delete Company API
* [x] Seller Dashboard API

## Class Summary

### CompanyService

createCompany()
- Create and save company

getAllCompanies()
- Fetch all companies

getCompanyById()
- Fetch company by id

mapToResponse()
- Convert Entity to DTO

updateCompany()
- Update company

deleteCompany()
- Delete company

getCompaniesByOwnerId()
- Fetch seller companies

---

## Milestone 3 - Financial Module

Status:
COMPLETED

Tasks:

* [x] Financial Entity
* [x] Financial CRUD
* [x] Valuation Engine

---

### ValuationService

generateValuation()
- Generate valuation from financial data

getValuationByCompanyId()
- Fetch valuation by company id

mapToResponse()
- Convert Entity to DTO

---

## Milestone 3.5 - Quality Pipeline

* [x] JUnit Setup
* [x] CompanyService Tests
* [x] FinancialService Tests
* [ ] AuthService Tests
* [ ] MockMvc API Tests
* [x] GitHub Actions CI Pipeline

---
## Class Summary

### FinancialService

createFinancial()
- Create and save financial record

getAllFinancials()
- Fetch all financial records

getFinancialById()
- Fetch financial record by id

getFinancialByCompanyId()
- Fetch financial record by company id

updateFinancial()
- Update financial record

deleteFinancial()
- Delete financial record

mapToResponse()
- Convert Entity to DTO
---

## Milestone 4 - Listing Module

Status:
NOT STARTED

Tasks:

* [ ] Listing Entity
* [ ] Listing CRUD
* [ ] Search API

---

## Milestone 5 - Buyer Module

Status:
NOT STARTED

Tasks:

* [ ] Buyer Profile
* [ ] Interest API
* [ ] Matching Engine

---

## Milestone 6 - React Frontend

Status:
NOT STARTED

Tasks:

* [ ] Login Page
* [ ] Registration Page
* [ ] Dashboard
* [ ] Company Form
* [ ] Listings Page

---

## Milestone 7 - Security Hardening

* [ ] Derive owner from JWT
* [ ] Restrict company creation to SELLER
* [ ] Restrict company update to owner
* [ ] Restrict company deletion to owner
* [ ] Implement role-based method security
* [ ] Add UserDetailsService
* [ ] Add ownership validation
* [ ] Add foreign key constraints

---

## Future Improvements

- Replace ownerId with User entity relationship (@ManyToOne)
- Derive owner from JWT instead of request body
- Enforce SELLER role for company creation
- Add foreign key between companies.owner_id and users.id

---

# Completed APIs

POST /api/auth/register
POST /api/auth/login
POST   /api/companies
GET    /api/companies
GET    /api/companies/{id}
PUT    /api/companies/{id}
DELETE /api/companies/{id}
GET    /api/companies/owner/{ownerId}
POST   /api/financials
GET    /api/financials
GET    /api/financials/{id}
GET    /api/financials/company/{companyId}
PUT    /api/financials/{id}
DELETE /api/financials/{id}
POST /api/valuations
GET  /api/valuations/company/{companyId}

---

# Pending APIs

To be updated

---

# Known Issues

None

---

# Current Status

Current Milestone:
Milestone 4 - Listing Module

Current Task:
Listing Entity

Next Task:


# Git History

## Commit 001

Message:
Initial authentication module setup

Features:

* Spring Boot Setup
* MySQL Configuration
* Package Structure
* User Entity
* Role Enum
* User Repository
* Registration API
* BCrypt Encryption
* Login API

# Git Information

Repository:
https://github.com/shubhamabhambure3/bizmart-platform

Branch:
main

Last Commit:
Configure JWT based Spring Security

## Project Handover Notes

### Completed Modules

1. Authentication Module
   - Registration
   - Login
   - JWT
   - Spring Security
   - Role-based JWT

2. Company Management Module
   - Company CRUD
   - Seller Dashboard API

### Current Database Tables

users
companies
company_financials
valuations


### Security Hardening Backlog

- Derive owner from JWT
- Restrict company creation to SELLER
- Restrict company update to owner
- Restrict company deletion to owner
- Add UserDetailsService
- Add ownership validation
- Add foreign key constraints

### Important Decisions

- Use explicit loops instead of Streams for readability
- Use Optional.isEmpty() instead of orElseThrow()
- Follow Controller -> Service -> Repository architecture
- Commit after completing a feature/module

Date:
2026-06-05