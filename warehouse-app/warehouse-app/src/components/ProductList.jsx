import { useState } from "react";
import { useEffect } from "react";
import { Grid, GridContainer, Table, Button } from '@trussworks/react-uswds';
import { useNavigate } from "react-router-dom";

const ProductList = () =>  {

    // TODO fetch data from backend and display in table
    // when the component is mounted

    const url = "http://localhost:8080/products";

    const [products, setProducts] = useState([]);
    const [loaded, setLoaded] = useState(false);

    const navigate = useNavigate();

    useEffect(() => {


        fetch(url)
            .then(data => data.json()) 
            .then(returnedData => {
                console.log(returnedData);
                setProducts(returnedData);
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
                                    <th>Category</th>
                                    <th>Quantity</th>
                                    <th>Storage Location</th>
                                    <th>Warehouse ID</th>
                                </tr>
                            </thead>
                            <tbody>
                                {loaded ?
                                    products.map(
                                        products => (
                                            <tr key={products.id}>
                                                <td>{products.category}</td>
                                                <td>{products.quantity}</td>
                                                <td>{products.storageLocation}</td>
                                                <td>{products.warehouse_id.id}</td> {/**To be fixed */}
                                                <td>
                                                    <Button onClick={() => navigate("/update-product")
                                                    }className = 'update-button' intent="primary">Update</Button>
                                                    <Button onClick={(e) => {
                                                        const delUrl = url + '/' + products.id;
                                                        console.log(delUrl);
                                                        fetch(delUrl, {method: 'DELETE', headers:{
                                                            'Content-Type': 'application/json'}
                                                        }).then((response) => {
                                                            if(!response.ok){
                                                                throw new Error('Something went wrong')
                                                            }
                                                            navigate('/products');
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

export default ProductList