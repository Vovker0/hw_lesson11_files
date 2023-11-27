package guru.qa.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IceCreamModel {
    private String brandName;
    private String productName;
    @JsonProperty("package")
    private String iceCreamPackage;
    private Integer volume;
    private String volumeUnits;
    private String[] ingredients;
    private NutritionFacts nutritionFacts;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getIceCreamPackage() {
        return iceCreamPackage;
    }

    public void setIceCreamPackage(String iceCreamPackage) {
        this.iceCreamPackage = iceCreamPackage;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getVolumeUnits() {
        return volumeUnits;
    }

    public void setVolumeUnits(String volumeUnits) {
        this.volumeUnits = volumeUnits;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public NutritionFacts getNutritionFacts() {
        return nutritionFacts;
    }

    public void setNutritionFacts(NutritionFacts nutritionFacts) {
        this.nutritionFacts = nutritionFacts;
    }

    public static class NutritionFacts {
        private Float servingSize;
        private String servingSizeUnits;
        private Integer calories;
        private Fat fat;
        private Carbohydrate carbohydrate;
        private Protein protein;
        private Minerals minerals;
        private Vitamins vitamins;

        public Float getServingSize() {
            return servingSize;
        }

        public void setServingSize(Float servingSize) {
            this.servingSize = servingSize;
        }

        public String getServingSizeUnits() {
            return servingSizeUnits;
        }

        public void setServingSizeUnits(String servingSizeUnits) {
            this.servingSizeUnits = servingSizeUnits;
        }

        public Integer getCalories() {
            return calories;
        }

        public void setCalories(Integer calories) {
            this.calories = calories;
        }

        public Fat getFat() {
            return fat;
        }

        public void setFat(Fat fat) {
            this.fat = fat;
        }

        public Carbohydrate getCarbohydrate() {
            return carbohydrate;
        }

        public void setCarbohydrate(Carbohydrate carbohydrate) {
            this.carbohydrate = carbohydrate;
        }

        public Protein getProtein() {
            return protein;
        }

        public void setProtein(Protein protein) {
            this.protein = protein;
        }

        public Minerals getMinerals() {
            return minerals;
        }

        public void setMinerals(Minerals minerals) {
            this.minerals = minerals;
        }

        public Vitamins getVitamins() {
            return vitamins;
        }

        public void setVitamins(Vitamins vitamins) {
            this.vitamins = vitamins;
        }

        public static class Fat {
            private String unitMeasure;
            private Float totalFat;
            private Float saturatedFat;
            private Float transFat;

            public String getUnitMeasure() {
                return unitMeasure;
            }

            public void setUnitMeasure(String unitMeasure) {
                this.unitMeasure = unitMeasure;
            }

            public Float getTotalFat() {
                return totalFat;
            }

            public void setTotalFat(Float totalFat) {
                this.totalFat = totalFat;
            }

            public Float getSaturatedFat() {
                return saturatedFat;
            }

            public void setSaturatedFat(Float saturatedFat) {
                this.saturatedFat = saturatedFat;
            }

            public Float getTransFat() {
                return transFat;
            }

            public void setTransFat(Float transFat) {
                this.transFat = transFat;
            }
        }

        public static class Carbohydrate {
            private String unitMeasure;
            private Float totalCarbohydrate;
            private Float dietaryFiber;
            private Float totalSugars;
            private Float inclAddedSugars;

            public String getUnitMeasure() {
                return unitMeasure;
            }

            public void setUnitMeasure(String unitMeasure) {
                this.unitMeasure = unitMeasure;
            }

            public Float getTotalCarbohydrate() {
                return totalCarbohydrate;
            }

            public void setTotalCarbohydrate(Float totalCarbohydrate) {
                this.totalCarbohydrate = totalCarbohydrate;
            }

            public Float getDietaryFiber() {
                return dietaryFiber;
            }

            public void setDietaryFiber(Float dietaryFiber) {
                this.dietaryFiber = dietaryFiber;
            }

            public Float getTotalSugars() {
                return totalSugars;
            }

            public void setTotalSugars(Float totalSugars) {
                this.totalSugars = totalSugars;
            }

            public Float getInclAddedSugars() {
                return inclAddedSugars;
            }

            public void setInclAddedSugars(Float inclAddedSugars) {
                this.inclAddedSugars = inclAddedSugars;
            }
        }

        public static class Protein {
            private String unitMeasure;
            private Float protein;

            public String getUnitMeasure() {
                return unitMeasure;
            }

            public void setUnitMeasure(String unitMeasure) {
                this.unitMeasure = unitMeasure;
            }

            public Float getProtein() {
                return protein;
            }

            public void setProtein(Float protein) {
                this.protein = protein;
            }
        }

        public static class Minerals {
            private String unitMeasure;
            private Float sodium;
            private Float calcium;
            private Float potassium;
            private Float iron;

            public String getUnitMeasure() {
                return unitMeasure;
            }

            public void setUnitMeasure(String unitMeasure) {
                this.unitMeasure = unitMeasure;
            }

            public Float getSodium() {
                return sodium;
            }

            public void setSodium(Float sodium) {
                this.sodium = sodium;
            }

            public Float getCalcium() {
                return calcium;
            }

            public void setCalcium(Float calcium) {
                this.calcium = calcium;
            }

            public Float getPotassium() {
                return potassium;
            }

            public void setPotassium(Float potassium) {
                this.potassium = potassium;
            }

            public Float getIron() {
                return iron;
            }

            public void setIron(Float iron) {
                this.iron = iron;
            }
        }

        public static class Vitamins {
            private String unitMeasure;
            private Float vitaminD;

            public String getUnitMeasure() {
                return unitMeasure;
            }

            public void setUnitMeasure(String unitMeasure) {
                this.unitMeasure = unitMeasure;
            }

            public Float getVitaminD() {
                return vitaminD;
            }

            public void setVitaminD(Float vitaminD) {
                this.vitaminD = vitaminD;
            }
        }
    }
}
