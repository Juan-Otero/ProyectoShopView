package com.example.proyectopoli.model

import com.example.proyectopoli.R

// Repositorio central que contiene todos los productos
object ProductRepository{

    // Función que retorna todos los productos existentes
    fun getAllProducts(): List<Product> {
        return listOf(

            // CELULARES
            Product(
                1001,
                "Iphone 15 Pro",
                "Apple | Iphone 15",
                4899000.0,
                Category.CELULARES,
                "https://support.apple.com/es-lamr/111829",
                listOf(
                    R.drawable.iphone_15_pro_1,
                    R.drawable.iphone_15_pro_2,
                    R.drawable.iphone_15_pro_3
                ),
                R.raw.iphone_15_pro_video
            ),

            Product(
                1002,
                "Motorola Edge 50 Fusion",
                "Smartphone Motorola",
                998000.0,
                Category.CELULARES,
                "https://www.motorola.com.co/motorola-edge-50-fusion-256-gb/p",
                listOf(
                    R.drawable.motorola_edge_50_1,
                    R.drawable.motorola_edge_50_2,
                    R.drawable.motorola_edge_50_3
                ),
                R.raw.motorola_edge_50_video
            ),

            Product(
                1003,
                "Xiaomi REDMI Note 14",
                "Xiaomi | REDMI",
                860000.0,
                Category.CELULARES,
                "https://www.mi.com/co/product/redmi-note-14/",
                listOf(
                    R.drawable.redmi_note_14_1,
                    R.drawable.redmi_note_14_2,
                    R.drawable.redmi_note_14_3
                ),
                R.raw.redmi_note_14_video
            ),

            Product(
                1004,
                "Samsung Galaxy A36",
                "Samsung | 5G 128GB",
                1540000.0,
                Category.CELULARES,
                "https://www.samsung.com/co/smartphones/galaxy-a/galaxy-a36-5g-awesome-black-256gb-sm-a366ezkgltc/",
                listOf(
                    R.drawable.samsung_a36_1,
                    R.drawable.samsung_a36_2,
                    R.drawable.samsung_a36_3
                ),
                R.raw.samsung_a36_video
            ),


            // TABLETS
            Product(
                2001,
                "Samsung S6 Lite 128GB",
                "Samsung | Oxford Gray",
                940000.0,
                Category.TABLETS,
                "https://www.samsung.com/co/tablets/galaxy-tab-s/galaxy-tab-s6-lite--2024--mint-128gb-sm-p620nlghcoo/",
                listOf(
                    R.drawable.samsung_s6_1,
                    R.drawable.samsung_s6_2,
                    R.drawable.samsung_s6_3,
                ),
                R.raw.samsung_s6_video
            ),

            Product(
                2002,
                "Honor Pad X8a 128GB",
                "Tablet | Honor 128GB",
                635000.0,
                Category.TABLETS,
                "https://www.honor.com/co/tablets/honor-pad-x8/",
                listOf(
                    R.drawable.honor_pad_x8_1,
                    R.drawable.honor_pad_x8_2,
                    R.drawable.honor_pad_x8_3
                ),
                R.raw.honor_pad_x8_video
            ),

            Product(
                2003,
                "Ipad 10.9' 10ma Gen",
                "Apple | Ipad",
                1670000.0,
                Category.TABLETS,
                "https://support.apple.com/es-co/111840",
                listOf(
                    R.drawable.ipad_1,
                    R.drawable.ipad_2,
                    R.drawable.ipad_3
                ),
                R.raw.ipad_video
            ),

            // LAPTOPS
            Product(
                3001,
                "HP 15.6' AMD Ryzen 7",
                "HP | Pavilion",
                2449000.0,
                Category.LAPTOPS,
                "https://www.hp.com/co-es/shop/portatil-hp-pavilion-15-eh3000la-80m53la.html",
                listOf(
                    R.drawable.hp_amd_1,
                    R.drawable.hp_amd_2,
                    R.drawable.hp_amd_3
                ),
                R.raw.hp_amd_video
            ),

            Product(
                3002,
                "Lenovo IdeaPad Slim 3",
                "Lenovo | Ideapad",
                2380000.0,
                Category.LAPTOPS,
                "https://www.lenovo.com/co/es/p/portatiles/ideapad/ideapad-serie-s/ideapad-slim-3-gen-8-15-inch-amd/82xq005xlm",
                listOf(
                    R.drawable.lenovo_ideapad_1,
                    R.drawable.lenovo_ideapad_2,
                    R.drawable.lenovo_ideapad_3
                ),
                R.raw.lenovo_ideapad_video
            ),

            Product(
                3003,
                "Acer Aspire 15.6' C7SG",
                "ACER | Aspire",
                1300000.0,
                Category.LAPTOPS,
                "https://www.acer.com/ar-es/laptops/aspire/aspire-7-intel",
                listOf(
                    R.drawable.acer_aspire_1,
                    R.drawable.acer_aspire_2,
                    R.drawable.acer_aspire_3
                ),
                R.raw.acer_aspire_video
            ),

            Product(
                3004,
                "Asus Vivobook Go 15.6'",
                "Asus | Vivobook",
                2100000.0,
                Category.LAPTOPS,
                "https://www.asus.com/co/laptops/for-home/vivobook/vivobook-15-x1502/",
                listOf(
                    R.drawable.asus_vivobook_1,
                    R.drawable.asus_vivobook_2,
                    R.drawable.asus_vivobook_3
                ),
                R.raw.asus_vivobook_video
            ),

            // ACCESORIOS
            Product(
                4001,
                "Huawei GT5 Pro",
                "Huawei | Smartwatch",
                1030000.0,
                Category.ACCESORIOS,
                "https://consumer.huawei.com/co/wearables/watch-gt5-pro/",
                listOf(
                    R.drawable.huawei_gt5_1,
                    R.drawable.huawei_gt5_2,
                    R.drawable.huawei_gt5_3
                ),
                R.raw.huawei_gt5_video
            ),

            Product(
                4002,
                "Samsung Galaxy Buds3 Pro",
                "Audifonos In Ear",
                640000.0,
                Category.ACCESORIOS,
                "https://www.samsung.com/co/audio-sound/galaxy-buds/galaxy-buds3-pro-silver-sm-r630nzaalta/",
                listOf(
                    R.drawable.samsung_buds_1,
                    R.drawable.samsung_buds_2,
                ),
                R.raw.samsung_buds_video
            ),

            Product(
                4003,
                "HyperX Quadcast S",
                "HyperX | Microfono",
                610000.0,
                Category.ACCESORIOS,
                "https://row.hyperx.com/es/products/hyperx-quadcast-s-usb-microphone?variant=40910061043917",
                listOf(
                    R.drawable.hyperx_1,
                    R.drawable.hyperx_2,
                    R.drawable.hyperx_3
                ),
                R.raw.hyperx_video
            )
        )
    }

    fun getById(productId: Int): Product? {
        return getAllProducts().find { it.prodId == productId }
    }

    // Funcion que retorna los productos correspondientes a determinada categoría
    fun getCategories(): List<Category> {
        return listOf(
            Category.CELULARES,
            Category.LAPTOPS,
            Category.TABLETS,
            Category.ACCESORIOS
        )
    }

    // Función que retorna 5 productos para mostrarlos como destacados en la pantalla de Home
    fun getFeaturedProduct(): List<Product>{
        return getAllProducts().take(5)
    }
}