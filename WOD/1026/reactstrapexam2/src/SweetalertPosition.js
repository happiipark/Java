import { Button } from 'reactstrap';
import Swal from 'sweetalert2';

function SweetalertPosition(){

    const openAlert = (flag, position) =>{
        Swal.fire({
            position:position,
            icon:"success",
            title:flag+"되었습니다.",
            showConfirmButton:false,
            timer:1500
        })
    }

    return(
        <div>
            <Button onClick={()=>openAlert("저장","center")}>저장</Button>
            <Button onClick={()=>openAlert("수정","bottom-end")}>수정</Button>
        </div>
    )
}

export default SweetalertPosition;