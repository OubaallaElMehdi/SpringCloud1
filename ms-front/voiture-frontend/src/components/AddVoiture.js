import React, { useState } from 'react';

const AddVoiture = ({ onAdd }) => {
  const [marque, setMarque] = useState('');
  const [matricule, setMatricule] = useState('');
  const [model, setModel] = useState('');
  const [clientId, setClientId] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    onAdd({ marque, matricule, model, clientId });
  };

  return (
    <form onSubmit={handleSubmit} className="bg-white shadow rounded-lg p-6">
      <h2 className="text-2xl font-bold mb-4">Add New Voiture</h2>
      <input
        type="text"
        placeholder="Marque"
        value={marque}
        onChange={(e) => setMarque(e.target.value)}
        className="block w-full mb-4 p-2 border rounded"
      />
      <input
        type="text"
        placeholder="Matricule"
        value={matricule}
        onChange={(e) => setMatricule(e.target.value)}
        className="block w-full mb-4 p-2 border rounded"
      />
      <input
        type="text"
        placeholder="Model"
        value={model}
        onChange={(e) => setModel(e.target.value)}
        className="block w-full mb-4 p-2 border rounded"
      />
      <input
        type="number"
        placeholder="Client ID"
        value={clientId}
        onChange={(e) => setClientId(e.target.value)}
        className="block w-full mb-4 p-2 border rounded"
      />
      <button className="bg-blue-500 text-white px-4 py-2 rounded">Add Voiture</button>
    </form>
  );
};

export default AddVoiture;
