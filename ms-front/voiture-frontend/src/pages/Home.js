import React from 'react';

const HomePage = () => {
  return (
    <div className="p-6 bg-gray-100 min-h-screen">
      <h1 className="text-3xl font-bold text-gray-700">Welcome to Voiture Management</h1>
      <div className="grid grid-cols-2 gap-6 mt-6">
        <div className="bg-white shadow rounded-lg p-4">
          <h2 className="text-xl font-bold">Manage Voitures</h2>
          <p className="text-gray-600 mt-2">Add, update, or delete voitures from the list.</p>
        </div>
        <div className="bg-white shadow rounded-lg p-4">
          <h2 className="text-xl font-bold">Manage Clients</h2>
          <p className="text-gray-600 mt-2">Add, update, or delete clients from the database.</p>
        </div>
      </div>
    </div>
  );
};

export default HomePage;
