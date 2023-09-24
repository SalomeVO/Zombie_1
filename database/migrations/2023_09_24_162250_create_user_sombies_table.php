<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('user_sombies', function (Blueprint $table) {
            $table->bigIncrements("id");
            $table->string("name");
            $table->integer("points");
            $table->string("email");
            $table->string("password");
            $table->string("dateZ");
            $table->string("image");

        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('user_sombies');
    }
};
