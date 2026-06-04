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

# Business Workflow

## Seller Journey

Seller Registration
↓
Login
↓
Create Company Profile
↓
Add Financial Information
↓
Generate Business Valuation
↓
Create Business Listing
↓
Receive Buyer Interest
↓
Connect With Buyer

## Buyer Journey

Buyer Registration
↓
Login
↓
Browse Listings
↓
Search Businesses
↓
View Company Details
↓
View Financial Information
↓
View Business Valuation
↓
Express Interest
↓
Connect With Seller

## Admin Journey

Admin Login
↓
Manage Users
↓
Manage Companies
↓
Manage Financial Records
↓
Manage Listings
↓
Monitor Buyer Interests
↓
Monitor Platform Activity
↓
Maintain Platform Integrity

# Domain Model

User
├── ADMIN
├── SELLER
└── BUYER

SELLER
│
└── Company
│
├── Financial Information
│
├── Valuation
│
└── Listing

BUYER
│
└── Interest
│
└── Company Listing

ADMIN
│
├── Manage Users
├── Manage Companies
├── Manage Financial Records
├── Manage Listings
└── Monitor Platform Activity

# Current Domain Relationships

User
│
├── Role
│      ├── ADMIN
│      ├── SELLER
│      └── BUYER
│
└── Company (future ownership relationship)

Company
│
├── Financial Information
├── Valuation
├── Listing
└── Seller Owner

Listing
│
└── Buyer Interests

# Future Ownership Rules

* SELLER can manage only their own companies.
* BUYER cannot create, update, or delete companies.
* ADMIN can manage platform data.
* Ownership will eventually be derived from JWT instead of request payload.
* ownerId will eventually be replaced by @ManyToOne User relationship.

# Quality Pipeline

Status:
NOT STARTED

Purpose:

* Automated Unit Testing
* Automated API Testing
* Automated Build Validation
* CI/CD Pipeline using GitHub Actions

Tasks:

* JUnit Setup
* CompanyService Tests
* AuthService Tests
* MockMvc API Tests
* GitHub Actions CI Pipeline

# Additional Important Decisions

* This is a startup MVP, not a college project.
* Authentication implemented first, authorization hardening later.
* Security gaps are tracked in Milestone 7 and must not be forgotten.
* Prefer complete class implementations over partial snippets.
* Explain class purpose before implementation.
* Maintain Class Summary section after each module.
* Prefer explicit loops over Streams for readability.
* Prefer Optional.isEmpty() over orElseThrow() during MVP phase.
* Follow Controller → Service → Repository architecture.
* Commit only after meaningful feature completion.
* Use GitHub Actions for CI/CD before Jenkins.
* Docker may be added after MVP completion.
* Security Hardening milestone is mandatory before project completion.


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
NOT STARTED

Tasks:

* [ ] Financial Entity
* [ ] Financial CRUD
* [ ] Valuation Engine

---

## Milestone 3 - Quality Pipeline

* [ ] JUnit Setup
* [ ] CompanyService Tests
* [ ] AuthService Tests
* [ ] MockMvc API Tests
* [ ] GitHub Actions CI Pipeline

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

---

# Pending APIs

To be updated

---

# Known Issues

None

---

# Current Status

Current Milestone:
Milestone 3 - Financial Module

Current Task:
Financial Entity

Next Task:
Financial Repository

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

### Current Milestone

Milestone 3 - Financial Module

### Current Task

Financial Entity

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
2026-06-04