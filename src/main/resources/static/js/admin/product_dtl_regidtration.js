class CommonApi {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new CommonApi();
        }

        return this.#instance;
    }

    getProductMstList() {
        let responseData = null;
        $.ajax ({
            async: false,
            type: "get",
            url: "/api/admin/option/products/mst",
            dataType: "json",
            success: (response) => {
                responseData = response.data;
            },
            error: (error) => {
                console.log(error);
            }
        });

        return responseData;
    }

    getProductSize(productId) {
        let responseData = null;
        $.ajax ({
            async: false,
            type: "get",
            url: "/api/admin/option/products/size/" + productId,
            dataType: "json",
            success: (response) => {
                responseData = response.data;
            },
            error: (error) => {
                console.log(error);
            }
        });

        return responseData;
    }

    registProductDtl(productDtlParams) {
        $.ajax({
            async: false,
            type: "post",
            url: "/api/admin/option/product/dtl",
            contentType: "application/jason",
            data: JSON.stringify(productDtlParams),
            dataType: "json",
            success: (response) => {
                alert("추가 완료");
                location.reload();
            },
            error: (error) => {
                console.log(error);
            }
        })
    }
}

class Option {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new Option();
        }

        return this.#instance;
    }

    setProductMstSelectOptions() {
        const pdtMstSelect = document.querySelector(".product-select");
        CommonApi.getInstance().getProductMstList().forEach(product => {
            pdtMstSelect.innerHTML += `
                <option value="${product.id}">(${product.category})${product.name}</option>
            `;
        });

    }

    addMstSelectEvent() {
        const pdtMstSelect = document.querySelector(".product-select");
        pdtMstSelect.onchange = () => {
            this.setSizeSelectOptions();
        }
    }

    setSizeSelectOptions() {
        const pdtSizeSelect = document.querySelector(".product-size");
        pdtSizeSelect.innerHTML = "";
        CommonApi.getInstance().getProductSizeList(productId).forEach(size => {
            pdtSizeSelect.innerHTML += `
            <option value="${size.size_id}">${size.sizeName}</option>
            `;
        })
    }

    addSubmitEvent() {
        const registButton = document.querySelector(".regist-button");
        registButton.onclink = () => {
            const productDtlParams = {
                "pdtId": document.querySelector(".product-select").value,
                "pdtSize": document.querySelector(".product-size").value,
                "pdtColor": document.querySelector(".product-color").value,
                "pdtStock": document.querySelector("product-stock").value
            }
        }
    }
}

window.onload = () => {
    Option.getInstance().setProductMstSelectOptions();
}