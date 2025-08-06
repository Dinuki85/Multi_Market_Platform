'use client';

export default function Modal({ isOpen, onClose, children }) {
  if (!isOpen) return null;

  return (
    <div className="fixed inset-0 z-50 flex items-center justify-center bg-black bg-opacity-40">
      <div className="relative w-full max-w-md p-6 bg-white rounded shadow-lg">
        <button
          onClick={onClose}
          className="absolute text-gray-600 top-2 right-2 hover:text-black"
        >
          ✕
        </button>
        {children}
      </div>
    </div>
  );
}
