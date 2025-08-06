'use client';

import { useState } from 'react';
import Modal from './modal';
import AuthForm from './AuthForm';
import { loginUser, registerUser } from '@/utils/api';


export default function Navbar() {
  const [openModal, setOpenModal] = useState(false);
  const [authType, setAuthType] = useState('signin');

  const handleOpen = (type) => {
    setAuthType(type);
    setOpenModal(true);
  };

  return (
    <>
      <nav className="flex items-center justify-between px-6 py-4 bg-gray-100 shadow">
        <h1 className="text-xl font-bold text-blue-600">eComSite</h1>
        <div className="space-x-4">
          <button
            className="px-4 py-1 text-sm border rounded hover:bg-blue-50"
            onClick={() => handleOpen('signin')}
          >
            Sign In
          </button>
          <button
            className="px-4 py-1 text-sm text-white bg-blue-600 border rounded hover:bg-blue-700"
            onClick={() => handleOpen('signup')}
          >
            Sign Up
          </button>
        </div>
      </nav>

      <Modal isOpen={openModal} onClose={() => setOpenModal(false)}>
  <AuthForm
    type={authType}
    onSubmit={authType === 'signup' ? registerUser : loginUser}
  />
</Modal>
    </>
  );
}
