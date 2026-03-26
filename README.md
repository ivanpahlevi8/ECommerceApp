# 🛒 Peer-to-Peer E-Commerce Marketplace
**A native Android application designed to facilitate seamless user-to-user buying and selling.**

[![Platform](https://img.shields.io/badge/platform-Android-green)](#)
[![Tech Stack](https://img.shields.io/badge/stack-Kotlin%20%7C%20.NET%20Core-blue)](#)
[![Database](https://img.shields.io/badge/database-SQL%20Server-lightgrey)](#)

---

## 📱 Project Overview
This project is a fully functional mobile marketplace platform. Unlike standard B2C e-commerce apps, this system handles a Peer-to-Peer (P2P) flow where any registered user can act as both a buyer and a seller. 

Building this required a strong systems mindset to manage complex entity relationships (Users, Products, Orders) and ensure seamless synchronization between the native Android client and the cloud-deployed .NET REST API.

---

## ✨ Core Features

### 1. Secure Authentication & Identity
* **User Onboarding:** Complete registration and login flows.
* **Session Management:** Utilizes robust local state management to handle user sessions, securely store credentials, and maintain auth states across app restarts.
* **Profile Management:** Users can update their personal information and manage their marketplace identity.

### 2. Full-Lifecycle Product Management (CRUD)
* **Inventory Control:** Sellers have a dedicated "Own Product" dashboard to view their active listings.
* **Seamless Publishing:** Users can easily upload new products with descriptions, categories, and images.
* **Real-time Editing:** Products can be updated or deleted with immediate reflection in the marketplace feed.

### 3. P2P Transaction Engine
* **Cart Management:** Buyers can browse the global marketplace and stage items in their cart.
* **Order Creation:** Streamlined checkout process to initiate a purchase.
* **Two-Way Order Tracking:** The transaction requires a dual-handshake: buyers create the order, and sellers must explicitly approve it before fulfillment, with tracking available for both parties.

---

## 🛠️ Technical Implementation & Architecture

### **Native Android Development**
The application is built entirely in **Kotlin** using **Android Studio**, adhering to modern Android development standards to ensure high performance and a native feel.

### **Clean Architecture**
The codebase is strictly organized using **Clean Architecture** principles. By separating the UI, Domain, and Data layers, the app remains highly scalable. This structure makes it easy to mock data for testing UI components independently from the network or database layers.

### **Full-Stack System Design**
While the focus is the mobile client, the app is powered by a robust backend architecture:
* **Backend:** A cloud-deployed `.NET Core` REST API.
* **Database:** `Microsoft SQL Server` for relational data integrity (handling the complex joins between Users, their uploaded Products, and multi-party Orders).

---

## 🔄 Application Flow

1. **Auth:** User Registers / Logs in.
2. **Discover:** User browses the marketplace feed.
3. **Stage:** User adds desired products to the cart.
4. **Checkout:** User creates an order request.
5. **Approval:** The item's Seller reviews and approves the order.
6. **Fulfillment:** Buyer tracks the order status.

---

## 📸 Interface Preview
*(Note: Replace the image links with your actual file paths in your repository)*

| Authentication | Seller Dashboard | Edit/Delete Products |
| :---: | :---: | :---: |
| ![Login/Register](link-to-auth-image) | ![Own Products](link-to-dashboard-image) | ![Product Management](link-to-management-image) |

---

## 🚀 How to Run Locally

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/ivanpahlevi8/ECommerceApp.git](https://github.com/ivanpahlevi8/ECommerceApp.git)
