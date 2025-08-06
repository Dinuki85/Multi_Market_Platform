import Image from "next/image";
import styles from "./page.module.css";

export default function Home() {
  return (
    <section className="flex flex-col items-center justify-center px-4 py-16 text-center">
      <h1 className="text-4xl font-bold text-blue-800 md:text-5xl">
        Welcome to Our E-Commerce Platform
      </h1>
      <p className="max-w-xl mt-4 text-gray-700">
        Discover a variety of products, seamless shopping, and fast delivery. Sign up now to explore!
      </p>
      <div className="mt-6 space-x-4">
        <button className="px-6 py-2 text-white transition bg-blue-600 rounded-lg hover:bg-blue-700">
          Sign In
        </button>
        <button className="px-6 py-2 text-blue-600 transition bg-white border border-blue-600 rounded-lg hover:bg-blue-50">
          Sign Up
        </button>
      </div>

    </section>
  );
}
