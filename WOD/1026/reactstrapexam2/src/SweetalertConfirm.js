import { Button } from 'reactstrap';
import Swal from 'sweetalert2';


function SweetalertConfirm(){

    const deleteAlert = () => {
        Swal.fire({
            title:"정말 삭제하시겠습니까?",
            icon:"question",
            showCancelButton:true,
            confirmButtonColor:"#4B088A",
            cancelButtonColor:"#01DF01",
            confirmButtonText:"예", 
            cancelButtonText:"아니오"
        }).then((res) => {
            if(res.value) {
                document.getElementById("deleteId").remove();
                Swal.fire("Delete","삭제완료","success")
            }
        })
    }

    return(
        <div>
            <h1 id="deleteId">삭제대상</h1>
            <Button onClick={deleteAlert}>삭제</Button>
        </div>
    )
}

export default SweetalertConfirm;