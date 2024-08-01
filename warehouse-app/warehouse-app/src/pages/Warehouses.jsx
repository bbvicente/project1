import { useState } from 'react';
import { WarehouseForm } from '../components/WarehouseForm';
import { Button } from '@trussworks/react-uswds'

export default function Warehouses() {
  
  const [shouldRender, setShouldRender] = useState(true);

    return (<>
        <h1>Warehouses</h1>

        <main className="form-container">
            <Button onClick={() => setShouldRender(!shouldRender)} className = 'create-button' type="button" accentStyle="warm" >CREATE</Button>
            {shouldRender ? <WarehouseForm />: null}
        </main>
      </>)
  }