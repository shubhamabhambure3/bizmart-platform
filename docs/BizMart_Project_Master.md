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
Running

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
* [ ] JWT Generation
* [ ] JWT Validation
* [ ] Spring Security Configuration

---

## Milestone 2 - Seller Module

Status:
NOT STARTED

Tasks:

* [ ] Company Entity
* [ ] Company CRUD
* [ ] Seller Dashboard API

---

## Milestone 3 - Financial Module

Status:
NOT STARTED

Tasks:

* [ ] Financial Entity
* [ ] Financial CRUD
* [ ] Valuation Engine

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

# Completed APIs

POST /api/auth/register

POST /api/auth/login

---

# Pending APIs

To be updated

---

# Known Issues

None

---

# Current Status

Current Milestone:
Milestone 1 - Authentication

Current Task:
JWT Authentication

Next Task:
TBD

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
Add project gitignore

Date:
2026-06-03