import { useState } from "react";
import { useEffect } from "react";
import { Grid, GridContainer, Table, Button } from '@trussworks/react-uswds';

export const InventoryList = () =>  {

    // TODO fetch data from backend and display in table
    // when the component is mounted

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
            //.catch(err => { alert(err); console.log(err) })
            //<Alert type="error" heading="Error status" headingLevel="h4">{testText}</Alert>

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