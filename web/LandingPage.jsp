<%-- 
    Document   : home
    Created on : Mar 12, 2025, 3:08:01 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pet Store Management</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <header>
        <h1>Pet Store Management System</h1>
    </header>
    
    <main>
        <section id="dashboard">
            <h2>Dashboard</h2>
            <p>Welcome to the Pet Store Management System.</p>
        </section>
        <section id="products">
            <h2>Products</h2>
            <form id="product-form">
                <input type="text" placeholder="Product Name" required>
                <input type="number" placeholder="Price" required>
                <input type="text" placeholder="Category" required>
                <button type="submit">Add Product</button>
            </form>
            <ul id="product-list"></ul>
        </section>
        <section id="customers">
            <h2>Customers</h2>
            <form id="customer-form">
                <input type="text" placeholder="Customer Name" required>
                <input type="email" placeholder="Email" required>
                <input type="text" placeholder="Phone Number" required>
                <button type="submit">Add Customer</button>
            </form>
            <ul id="customer-list"></ul>
        </section>
        <section id="orders">
            <h2>Orders</h2>
            <p>Order management will be displayed here.</p>
        </section>
    </main>
    <script src="script.js"></script>
</body>
</html>

