import React from 'react';

const VoituresPage = ({ voitures }) => {
  return (
    <div className="p-6 bg-gray-100 min-h-screen">
      <h1 className="text-3xl font-bold text-gray-700">Voitures List</h1>
      <table className="table-auto w-full bg-white shadow rounded-lg mt-6">
        <thead>
          <tr>
            <th className="px-4 py-2">ID</th>
            <th className="px-4 py-2">Marque</th>
            <th className="px-4 py-2">Matricule</th>
            <th className="px-4 py-2">Model</th>
            <th className="px-4 py-2">Actions</th>
          </tr>
        </thead>
        <tbody>
          {voitures.map((voiture) => (
            <tr key={voiture.id}>
              <td className="border px-4 py-2">{voiture.id}</td>
              <td className="border px-4 py-2">{voiture.marque}</td>
              <td className="border px-4 py-2">{voiture.matricule}</td>
              <td className="border px-4 py-2">{voiture.model}</td>
              <td className="border px-4 py-2">
                <button className="bg-blue-500 text-white px-2 py-1 rounded">
                  Edit
                </button>
                <button className="bg-red-500 text-white px-2 py-1 rounded ml-2">
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default VoituresPage;
