'use client';

import { useState } from "react";

export default function AuthForm({ type = "signup", onSubmit }) {
  const [formData, setFormData] = useState({
    name: "",
    email: "",
    password: "",
    role: "BUYER",
  });

  const [message, setMessage] = useState(null);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
  };

  const handleSubmit = async (e) => {
  e.preventDefault();
  const msg = await onSubmit(formData);
  setMessage(msg);
  if (msg.includes('successful')) {
    setTimeout(() => window.location.reload(), 1000); // optional
  }
};


  return (
    <div className="max-w-md p-6 mx-auto mt-10 bg-white rounded shadow">
      <h2 className="mb-4 text-2xl font-bold text-center">
        {type === "signup" ? "Create an Account" : "Sign In"}
      </h2>
      <form onSubmit={handleSubmit} className="space-y-4">
        {type === "signup" && (
          <input
            name="name"
            type="text"
            placeholder="Full Name"
            value={formData.name}
            onChange={handleChange}
            className="w-full px-4 py-2 border rounded"
            required
          />
        )}
        <input
          name="email"
          type="email"
          placeholder="Email"
          value={formData.email}
          onChange={handleChange}
          className="w-full px-4 py-2 border rounded"
          required
        />
        <input
          name="password"
          type="password"
          placeholder="Password"
          value={formData.password}
          onChange={handleChange}
          className="w-full px-4 py-2 border rounded"
          required
        />
        {type === "signup" && (
          <select
            name="role"
            value={formData.role}
            onChange={handleChange}
            className="w-full px-4 py-2 border rounded"
          >
            <option value="BUYER">Buyer</option>
            <option value="SELLER">Seller</option>
          </select>
        )}
        <button
          type="submit"
          className="w-full py-2 text-white bg-blue-600 rounded hover:bg-blue-700"
        >
          {type === "signup" ? "Register" : "Login"}
        </button>
        {message && (
          <p className="mt-2 text-sm text-center text-gray-700">{message}</p>
        )}
      </form>
    </div>
  );
}
