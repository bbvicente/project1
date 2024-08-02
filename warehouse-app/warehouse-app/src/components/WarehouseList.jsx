import { useState } from "react";
import { useEffect } from "react";
import { Grid, GridContainer, Table, Button } from '@trussworks/react-uswds';
import { useNavigate } from "react-router-dom";

const WarehouseList = () =>  {

    // TODO fetch data from backend and display in table
    // when the component is mounted

    const url = "http://localhost:8080/warehouses";

    const [warehouses, setWarehouses] = useState([]);
    const [loaded, setLoaded] = useState(false);

    const navigate = useNavigate();

    useEffect(() => {


        fetch(url)
            .then(data => data.json()) 
            .then(returnedData => {
                console.log(returnedData);
                setWarehouses(returnedData);
                setLoaded(true);
            })
            .catch(err => { alert(err); console.log(err) })

    }, [])

    return (
        <>
            <div>
            <GridContainer >
                <Grid row>
                    <Grid col="1"></Grid>
                    <Grid col="10">

                        <Table bordered className="table-border">
                            <thead>
                                <tr>
                                    <th>WH#</th>
                                    <th>Name</th>
                                    <th>City</th>
                                    <th>State</th>
                                    <th>Capacity</th>
                                </tr>
                            </thead>
                            <tbody>
                                {loaded ?
                                    warehouses.map(
                                        warehouses => (
                                            <tr key={warehouses.id}>
                                                <td>{warehouses.id}</td>
                                                <td>{warehouses.name}</td>
                                                <td>{warehouses.city}</td>
                                                <td>{warehouses.state}</td>
                                                <td>{warehouses.capacity}</td>
                                                <td>
                                                    <Button onClick={() => navigate("/update-warehouse")
                                                    }className = 'update-button' intent="primary" >Update</Button>
                                                    <Button onClick={(e) => {
                                                        const delUrl = url + '/' + warehouses.id;
                                                        console.log(delUrl);
                                                        fetch(delUrl, {method: 'DELETE', headers:{
                                                            'Content-Type': 'application/json'}
                                                        }).then((response) => {
                                                            if(!response.ok){
                                                                throw new Error('Something went wrong')
                                                            }
                                                            navigate('/success-delete-page');
                                                         }).catch((e) => {console.log(e)});
                                                    }} className = 'delete-button' intent="danger">Delete</Button>
                                                </td>
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

export default WarehouseList