import { useState } from "react";
import { useEffect } from "react";
import { Grid, GridContainer, Table, Button } from '@trussworks/react-uswds';

{/** This component renders a list of the warehouse inventory */}
export const InventoryList = () =>  {

    const url = "http://localhost:8080/products/current-inventory";

    const [inventory, setInventory] = useState([]);
    const [loaded, setLoaded] = useState(false);

    useEffect(() => {


        fetch(url)
            .then(data => data.json()) 
            .then(returnedData => {
                console.log(returnedData);
                setInventory(returnedData);
                setLoaded(true);
            })
            .catch(err => { alert(err); console.log(err) })

    }, [])

    return (
        <>
            <div>
            <GridContainer>
                <Grid row>
                    <Grid col="1"></Grid>
                    <Grid col="10">

                        <Table bordered className="table-border">
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Quantity</th>
                                    <th>Capacity</th>
                                </tr>
                            </thead>
                            <tbody>
                                {loaded ?
                                    inventory.map(
                                        inventory => (
                                            <tr key={inventory.id}>
                                                <td>{inventory.name}</td>
                                                <td>{inventory.quantity}</td>
                                                <td>{inventory.capacity}</td>
                                            </tr>
                                        )) :
                                    (<tr><td colSpan='2'>Loading...</td></tr>)
                                }
                            </tbody>
                        </Table>
                    </Grid>
                    <Grid col="1"></Grid>

                </Grid>
            </GridContainer>
            </div>
        </>
    );
}

export default InventoryList