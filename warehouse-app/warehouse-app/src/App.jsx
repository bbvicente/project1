//import { useState } from 'react'
import './App.css'
import Navbar from './components/Navbar'
import Inventory from './pages/Inventory'
import Warehouses from './pages/Warehouses'
//import { WarehouseForm } from './components/WarehouseForm'
//import WarehouseList from './components/WarehouseList'
import { Routes, Route } from 'react-router-dom'
//import { Button, GridContainer } from '@trussworks/react-uswds'
//import { CreateWarehouse } from './pages/CreateWarehouse'

function App() {

  return (
  <>
        <Navbar/>
        <div className='main-body'>
          <Routes>
            <Route path='/' element={<Warehouses/>}></Route>
            <Route path='/inventory' element={<Inventory/>}></Route>
          </Routes>
        </div>
        
        {/* <main className="container-center">
          <GridContainer containerSize="desktop">
            <WarehouseList />
          </GridContainer>
      </main> */}
  </>)
}

export default App
