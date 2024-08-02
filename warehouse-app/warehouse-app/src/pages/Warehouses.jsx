import { useState } from 'react';
import { WarehouseForm } from '../components/WarehouseForm';
import { Button, GridContainer } from '@trussworks/react-uswds'
import WarehouseList from '../components/WarehouseList';
import { useNavigate } from "react-router-dom";

{/* Warehouses page */}
export default function Warehouses() {
  
  const [shouldRender, setShouldRender] = useState(0);
  const navigate = useNavigate();

    return (<>
        <h1>Warehouses</h1>

        <main>
           
           {/**Button to add warehouse */}
          <div>
            <Button onClick={() => navigate("/create-warehouse")} className = 'create-button' type="button" accentStyle="warm" >ADD WAREHOUSE</Button>
              {shouldRender ? <WarehouseForm />: null}
          </div>
          
          {/** List of warehouses */}
          <GridContainer className="container-center" containerSize="desktop">
            <WarehouseList />
          </GridContainer>
     
        </main>
      </>)
  }